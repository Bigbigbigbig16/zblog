DROP TABLE IF EXISTS t_users;
DROP TABLE IF EXISTS t_relationships;
DROP TABLE IF EXISTS t_metas;
DROP TABLE IF EXISTS t_logs;
DROP TABLE IF EXISTS t_contents;
DROP TABLE IF EXISTS t_comments;
DROP TABLE IF EXISTS t_attach;

CREATE TABLE t_users (uid INTEGER auto_increment PRIMARY KEY UNIQUE NOT NULL, username VARCHAR (64) UNIQUE NOT NULL, password VARCHAR (64) NOT NULL, email VARCHAR (100), home_url VARCHAR (255), screen_name VARCHAR (100), created INTEGER (10) NOT NULL, activated INTEGER (10), logged INTEGER (10), group_name VARCHAR (16));

CREATE TABLE t_relationships (cid INTEGER (10) NOT NULL, mid INTEGER (10) NOT NULL);

CREATE TABLE t_metas (mid INTEGER  auto_increment primary key UNIQUE NOT NULL,name VARCHAR (200) NOT NULL, slug VARCHAR (200), type VARCHAR (32) NOT NULL, description VARCHAR (255),sort INTEGER (4) DEFAULT '1', parent INTEGER (10) DEFAULT '0');

INSERT INTO t_metas (mid, name, slug, type, description, sort, parent) VALUES (1, '默认分类', NULL, 'category', NULL, 0, 0);

CREATE TABLE t_options (name VARCHAR (100) PRIMARY KEY UNIQUE NOT NULL, value TEXT, description VARCHAR (255));
INSERT INTO t_options (name, value, description) VALUES ('site_title', 'Tale博客系统', '');
INSERT INTO t_options (name, value, description) VALUES ('social_weibo', '', NULL);
INSERT INTO t_options (name, value, description) VALUES ('social_zhihu', '', NULL);
INSERT INTO t_options (name, value, description) VALUES ('social_github', '', NULL);
INSERT INTO t_options (name, value, description) VALUES ('social_twitter', '', NULL);
INSERT INTO t_options (name, value, description) VALUES ('allow_install', '0', '是否允许重新安装博客');
INSERT INTO t_options (name, value, description) VALUES ('site_theme', 'default', NULL);
INSERT INTO t_options (name, value, description) VALUES ('site_keywords', '博客系统,Blade框架,Tale', NULL);
INSERT INTO t_options (name, value, description) VALUES ('site_description', '博客系统,Blade框架,Tale', NULL);


CREATE TABLE t_logs (id INTEGER auto_increment primary key UNIQUE NOT NULL, action VARCHAR (100) NOT NULL, data VARCHAR (2000), author_id INTEGER (10) NOT NULL, ip VARCHAR (20), created INTEGER (10) NOT NULL);


CREATE TABLE t_contents ( cid INTEGER auto_increment primary key NOT NULL UNIQUE, title VARCHAR (255) NOT NULL, slug VARCHAR (255) , thumb_img VARCHAR(255), created INTEGER (10) NOT NULL, modified INTEGER (10), content TEXT, author_id INTEGER (10) NOT NULL, type VARCHAR (16) NOT NULL, status VARCHAR (16) NOT NULL, fmt_type VARCHAR (16) DEFAULT 'markdown', tags VARCHAR (200), categories VARCHAR (200), hits INTEGER (10) DEFAULT '0', comments_num INTEGER (1) DEFAULT '0', allow_comment INTEGER (1) DEFAULT '1', allow_ping INTEGER (1), allow_feed INTEGER (1),CONSTRAINT idx_u_slug UNIQUE (slug) );


CREATE TABLE t_comments (coid INTEGER auto_increment primary key NOT NULL, cid INTEGER DEFAULT '0' NOT NULL, created INTEGER (10) NOT NULL, author VARCHAR (200) NOT NULL, author_id INTEGER (10) DEFAULT '0', owner_id INTEGER (10) DEFAULT '0', mail VARCHAR (200) NOT NULL, url VARCHAR (200), ip VARCHAR (64), agent VARCHAR (200), content TEXT NOT NULL, type VARCHAR (16), status VARCHAR (16), parent INTEGER (10) DEFAULT '0');


CREATE TABLE t_attach (id INTEGER PRIMARY KEY auto_increment NOT NULL, fname VARCHAR (100) NOT NULL, ftype VARCHAR (50), fkey VARCHAR (100) NOT NULL, author_id INTEGER (10) NOT NULL, created INTEGER (10) NOT NULL);
