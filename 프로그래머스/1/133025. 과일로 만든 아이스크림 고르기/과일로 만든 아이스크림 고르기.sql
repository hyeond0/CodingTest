select fh.FLAVOR
from FIRST_HALF fh
inner join ICECREAM_INFO ic on fh.FLAVOR = ic.FLAVOR
where fh.TOTAL_ORDER >= 3000 and ic.INGREDIENT_TYPE = 'fruit_based'
order by fh.TOTAL_ORDER desc