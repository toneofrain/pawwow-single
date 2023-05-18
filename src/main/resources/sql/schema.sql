CREATE SCHEMA IF NOT EXISTS pawwow DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

USE pawwow;

DROP TABLE IF EXISTS outbox;

DROP TABLE IF EXISTS vote;

DROP TABLE IF EXISTS pet;

CREATE TABLE pet (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    profile_image VARCHAR(255) NOT NULL,
    brief_description VARCHAR(255) NOT NULL,
    detail_description VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    modified_at TIMESTAMP NOT NULL
);

CREATE TABLE vote (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    pet_id BIGINT UNSIGNED NOT NULL,
    voter VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE outbox (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    aggregate_type VARCHAR(255) NOT NULL,
    aggregate_id BIGINT UNSIGNED NOT NULL,
    event_type VARCHAR(255) NOT NULL,
    occurred_at TIMESTAMP NOT NULL
);

ALTER TABLE vote
ADD CONSTRAINT fk_pet_vote
FOREIGN KEY (pet_id)
REFERENCES pet (id)
ON DELETE CASCADE;
