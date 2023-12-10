create table TIME_SLOT_INFO(
    SLOT_ID     int auto_increment primary key,
    START_TIME  timestamp not null,
    END_TIME  timestamp not null,
    TIME_SLOT_STAT varchar(2),
    created     timestamp not null,
    updated     timestamp null,
    version     int
);

create table TIME_SLOT_BOOKING_INFO(
    ID          int auto_increment primary key,
    EMAIL       varchar(30),
    SLOT_ID     int,
    BOOK_STAT   varchar(2) not null,
    created     timestamp(6) not null,
    updated     timestamp(6) null,
    version     int,
    FOREIGN KEY (SLOT_ID)
          REFERENCES TIME_SLOT_INFO(SLOT_ID)
);