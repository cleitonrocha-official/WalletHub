package com.ef;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.lang.System.in;
import static java.lang.System.out;
import static java.lang.System.exit;
import javax.persistence.EntityManager;

import org.apache.commons.io.IOUtils;

import com.ef.args.CommandList;
import com.ef.args.CreateCommand;
import com.ef.args.Duration;
import com.ef.entity.LogEntity;
import com.ef.entity.LogQuery;
import com.ef.util.DateFormatterUtil;
import com.ef.util.JPAUtil;

public class Roles {

	private List<LogEntity> logEntities = new ArrayList<LogEntity>();
	private EntityManager em = new JPAUtil().getEntityManager();

	public Roles(String[] arguments) {

		try {
			out.println("loading");

			for (String argument : arguments)
				CreateCommand.tryThis(argument);

			this.loadLogs();

			this.startSearch();

			out.println(logEntities.size());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.println("Exit");
			exit(0);
		}

	}

	@SuppressWarnings("unchecked")
	private void loadLogs() throws IOException {
		InputStream inputStream = new FileInputStream(
				new File(CommandList.getInstance().getAccessLog()).getAbsolutePath());
		List<String> doc = IOUtils.readLines(inputStream, "UTF-8");
		doc.forEach(line -> saveLog(line));
	}

	private void startSearch() throws IOException {

		List<LogEntity> logCollection = logEntities.parallelStream()
				.filter(l -> l.getDate().isAfter(CommandList.getInstance().getStartDate())
						&& l.getDate().isBefore(this.endDate()))
				.limit(CommandList.getInstance().getThreShould()).collect(Collectors.toList());

		logCollection.forEach(out::println);

		String comentary = scanerConsole();
		em.getTransaction().begin();
		logCollection.forEach(l -> em.persist(l));
		em.persist(new LogQuery(logCollection, comentary));
		em.getTransaction().commit();

	}

	private String scanerConsole() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
		out.print("\nEnter comentary for this query: ");
		return bufferedReader.readLine();
	}

	private LocalDateTime endDate() {
		return (CommandList.getInstance().getDuration().equals(Duration.HOURLY))
				? CommandList.getInstance().getStartDate().plusHours(1)
				: CommandList.getInstance().getStartDate().plusDays(1);
	}

	private void saveLog(String line) {
		LogEntity entity = new LogEntity();
		String[] cells = line.split("\\|");
		for (int i = 0; i < 5; i++) {
			switch (i) {
			case 0:
				entity.setDate(LocalDateTime.parse(cells[i], DateFormatterUtil.forReadLog()));
				break;
			case 1:
				entity.setIp(cells[i]);
				break;
			case 2:
				entity.setRequest(cells[i]);
				break;
			case 3:
				entity.setStatus(Integer.parseInt(cells[i]));
				break;
			case 4:
				entity.setUserAgent(cells[i]);
				break;
			}

		}

		logEntities.add(entity);

	}

}
