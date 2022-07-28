select e.event_type, 
	(e.value - (	
		select ev.value 
		from events ev 
        where ev.event_type = e.event_type
		order by time ASC limit 0, 1
    )) as value 
from events e order by e.event_type, e.time;