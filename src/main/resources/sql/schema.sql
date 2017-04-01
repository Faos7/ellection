CREATE TABLE public.candidate
(
  id bigint NOT NULL,
  first_name character varying(255),
  foto character varying(255),
  mainvotesnumber bigint,
  password character varying(255),
  secvoicenumber bigint,
  second_name character varying(255),
  third_name character varying(255),
  username character varying(255),
  CONSTRAINT candidate_pkey PRIMARY KEY (id)
);

CREATE TABLE public.candidate_position
(
  user_id bigint NOT NULL,
  votingpull_id bigint NOT NULL,
  CONSTRAINT candidate_position_pkey PRIMARY KEY (user_id, votingpull_id),
  CONSTRAINT fk3y8pdq8lr8ghmi6w86cl4a0ew FOREIGN KEY (votingpull_id)
  REFERENCES public."position" (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkcmaia3hiy6ufjvxdcd3q3xqqc FOREIGN KEY (user_id)
  REFERENCES public.candidate (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_i5oxitwfxgrw2a67pgn8tadms UNIQUE (votingpull_id)
);

CREATE TABLE public.candidates_pull
(
  voices integer,
  candidate_id bigint NOT NULL,
  position_id bigint NOT NULL,
  CONSTRAINT candidates_pull_pkey PRIMARY KEY (candidate_id, position_id),
  CONSTRAINT fkk7dexvy7v2e4urk9bu5rniu4q FOREIGN KEY (candidate_id)
  REFERENCES public.candidate (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkmy71taeftoqqr9to66wqy7tfj FOREIGN KEY (position_id)
  REFERENCES public.position (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE public.position
(
  id bigint NOT NULL,
  name character varying(255),
  winner bytea,
  CONSTRAINT position_pkey PRIMARY KEY (id)
)