use musicdb;

create table song(
	songID int auto_increment,
    image varchar (120),
    title varchar (50),    
    artist varchar (50),
    audio_url varchar (120),
    constraint pk_song primary key(songID)
);

create table post(
	postID int auto_increment,
    comment varchar (100),
    date datetime default now(),
	constraint pk_post primary key(postID)
);

/*create table post(
	postID int auto_increment,
    comment varchar (100),
    date datetime default now(),
    userID int,
	constraint pk_post primary key(postID),
    constraint fk_post foreign key(userID) references user(userid)
);*/

create table user(
	userid int auto_increment,
    name varchar (20),
    password varchar (20),
    constraint pk_user primary key(userid)
);

select * from song;
select * from post;
select * from user;

drop table song;
drop table post;