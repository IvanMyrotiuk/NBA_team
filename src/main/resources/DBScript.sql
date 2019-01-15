CREATE DATABASE nba;
CREATE SEQUENCE player_id_seq;

CREATE TABLE team
(
  team_id varchar(100) NOT NULL PRIMARY KEY,
  abbreviation varchar(45) NOT NULL,
  active boolean NOT NULL,
  first_name varchar(45) NOT NULL,
  last_name varchar(45) NOT NULL,
  conference varchar(45) NOT NULL,
  division varchar(45) NOT NULL,
  site_name varchar(45) NOT NULL,
  city varchar(45) NOT NULL,
  state varchar(45) NOT NULL,
  full_name varchar(45) NOT NULL
)

CREATE TABLE player
(
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('player_id_seq'),
  team_id varchar(100) NOT NULL FOREIGN KEY REFERENCES team (team_id) ON UPDATE CASCADE ON DELETE RESTRICT,
  name varchar(45) NOT NULL,
  phone varchar(45) NOT NULL,
  height integer
)
