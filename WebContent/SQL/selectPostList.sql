select * from  $bbsName$ where delflg != '9' or delflg is null order by postno desc limit $startPost$, $postPerPage$