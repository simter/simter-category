/**
 * Create table script.
 * @author RJ
 */
create table st_category (
  id     serial primary key,
  pid    int references st_category on delete cascade,
  status smallint     not null,
  name   varchar(100) not null,
  sn     varchar(50)  not null,
  constraint st_category_unique_pid_name unique (pid, name),
  constraint st_category_unique_pid_sn unique (pid, sn)
);
comment on table st_category is 'Category';
comment on column st_category.pid is 'Parent Category ID';
comment on column st_category.status is 'Status: 1-Draft, 2-Enabled, 4-Disabled, 8-Deleted';
comment on column st_category.name is 'Name';
comment on column st_category.sn is 'Code or order number';

-- Keep ID=1 as ROOT node
insert into st_category (pid, status, name, sn) values (null, 0, 'ROOT', '0');