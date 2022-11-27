create table ca_big_category
(
    cate_name varchar(255) not null
        primary key,
    count     bigint null
);

create table ca_sub_category
(
    cate_name     varchar(255) not null
        primary key,
    count         bigint null,
    big_cate_name varchar(255) null
);

create table cafe_article
(
    ca_id      bigint auto_increment
        primary key,
    board_name varchar(255) null,
    cafe_name  varchar(255) null,
    content    varchar(255) null,
    created_at datetime(6) null,
    title      varchar(255) null,
    url        varchar(255) null,
    writer     varchar(255) null
);

create table repair_order
(
    ro_id               bigint auto_increment
        primary key,
    big_phenom          varchar(255) null,
    cause               varchar(255) null,
    cause_part          varchar(255) null,
    cause_part_cluster  varchar(255) null,
    cause_part_name_eng varchar(255) null,
    cause_part_name_kor varchar(255) null,
    location            varchar(255) null,
    part_number         varchar(255) null,
    problematic         varchar(255) null,
    special_note        varchar(255) null,
    sub_phenom          varchar(255) null,
    vehicle_type        varchar(255) null
);

create table ro_big_category
(
    cate_name varchar(255) not null
        primary key,
    count     bigint null
);

create table ro_sub_category
(
    cate_name     varchar(255) not null
        primary key,
    count         bigint null,
    big_cate_name varchar(255) null
);

create table similarity
(
    similarity_id bigint not null
        primary key,
    ca_id         bigint null,
    ro_id         bigint null
);

create table ca_keyword
(
    word  varchar(255) not null
        primary key,
    count bigint null
);

create table ro_keyword
(
    word  varchar(255) not null
        primary key,
    count bigint null
);