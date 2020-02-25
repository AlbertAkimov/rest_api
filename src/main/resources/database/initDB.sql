create table if not exists persons(
    id bigint auto_increment primary key,
    first_name varchar(50) not null,
    last_name varchar(100) not null
)
