CREATE TABLE movie (
    id serial PRIMARY KEY,
    title varchar(255) NOT NULL,
    release_date date,
    rating numeric,
    created_at timestamp,
    description text,
    updated_at timestamp
);