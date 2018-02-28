select ip, count(*) qt 
from wallethub.log_entity  
where date_time
between '2017-01-01 13:00:00' and '2017-01-01 14:00:00'
group by ip
having count(*) > 100