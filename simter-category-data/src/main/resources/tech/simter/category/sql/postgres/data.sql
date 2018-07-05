/**
 * Data initialize script.
 * @author RJ
 */
-- Keep root node ID=1
insert into st_category (id, pid, status, name, sn)
values (1, null, 0, 'ROOT', '0');