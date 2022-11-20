create table cafe_article
(
    id             bigint auto_increment
        primary key,
    created_at     timestamp(6) null,
    modified_at    timestamp(6) null,
    broad_name     varchar(255) null,
    cafe_name      varchar(255) null,
    category       varchar(255) null,
    content        varchar(255) null,
    doc_created_at timestamp(6) null,
    is_mailing     bit null,
    period int null,
    title          varchar(255) null,
    url            varchar(255) null,
    user_name      varchar(255) null,
    view_count     bigint null
);

create table comment
(
    comment_id  bigint auto_increment
        primary key,
    created_at  timestamp(6) null,
    modified_at timestamp(6) null,
    content     varchar(255) null,
    post_id     bigint null
);


-- auto-generated definition
create table repair_order
(
    ro_id                 bigint auto_increment
        primary key,
    created_at            timestamp(6) null,
    modified_at           timestamp(6) null,
    cause                 varchar(255) null,
    cause_part            varchar(255) null,
    cause_part_cluster    varchar(255) null,
    cause_part_name_eng   varchar(255) null,
    cause_part_name_kor   varchar(255) null,
    location              varchar(255) null,
    part_number           varchar(255) null,
    problematic_situation varchar(255) null,
    special_note          varchar(255) null,
    symptom               varchar(255) null,
    vehicle_type          varchar(255) null
);

create table ro_mapping_post
(
    post_id     bigint auto_increment
        primary key,
    created_at  timestamp(6) null,
    modified_at timestamp(6) null,
    ca_id       bigint not null,
    ro_id       bigint not null
);
