select 
    ug.TITLE, 
    ug.BOARD_ID, 
    ur.REPLY_ID, 
    ur.WRITER_ID, 
    ur.CONTENTS, 
    date_format(ur.CREATED_DATE, '%Y-%m-%d') CREATED_DATE
from USED_GOODS_BOARD ug
inner join used_goods_reply ur
on ug.BOARD_ID = ur.BOARD_ID
where date_format(ug.CREATED_DATE, '%Y-%m') = '2022-10'
order by CREATED_DATE asc, title asc;