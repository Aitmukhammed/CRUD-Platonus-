
1. перед запуском надо прогнать в базе данных(mysql)

create table if not exists products.product
(
id           bigint auto_increment
primary key,
quantities   int          not null,
amount       int          not null,
product_name varchar(255) null
)
engine = MyISAM;
2. настройки подключения к базе данных в application.properties