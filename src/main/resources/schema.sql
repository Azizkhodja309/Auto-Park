create table if not exists auto_park
(
    id   bigserial primary key,
    name varchar
);

create table if not exists floor
(
    id      bigserial primary key,
    name    varchar,
    park_id bigint references auto_park
);

create table if not exists place
(
    id       bigserial primary key,
    name     varchar,
    empty    boolean,
    floor_id bigint references floor
);