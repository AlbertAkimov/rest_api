create table if not exists customers(
    id bigint auto_increment primary key,
    uuid_id varchar(36),
    first_name varchar(50) not null,
    last_name varchar(100) not null,
    status varchar(25) default 'ACTIVE',
    unique (uuid_id)
);

create table if not exists cards(
    id bigint auto_increment primary key,
    id_customer bigint,
    uuid_id varchar(36),
    created timestamp default CURRENT_TIMESTAMP,
    updated timestamp default CURRENT_TIMESTAMP,
    number_card varchar(100),
    type_card ENUM('Discount') default 'Discount',
    discount_percentage int default 3,
    status varchar(25) default 'ACTIVE',
    accumulation bigint default 0,
    unique (uuid_id),
    foreign key (id_customer) references customers(id)
);

create table if not exists orders(
    id bigint auto_increment primary key,
    id_customer bigint,
    id_card bigint,
    id_product bigint not null,
    

)

#///////////////////////////////////////////////////////////////////////////
create table if not exists roles(
    id bigint auto_increment primary key not null,
    uuid_id varchar(36),
    name varchar(100),
    unique (name)
);

create table if not exists users(
    id bigint auto_increment primary key not null,
    uuid_id varchar(36),
    username varchar(255),
    password varchar(255),
    firstName varchar(255),
    lastName varchar(255),
    email varchar(255),
    created timestamp default CURRENT_TIMESTAMP,
    updated timestamp default CURRENT_TIMESTAMP,
    status varchar(25) default 'ACTIVE',
    unique(username)
);

create table if not exists users_roles(
    user_id bigint,
    role_id bigint,

    foreign key(user_id) references users(id),
    foreign key (role_id) references roles(id),
    UNIQUE (user_id, role_id)
);