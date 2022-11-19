--
-- Add extension to use 'uuid_generate_v4'.
--
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

--
-- Drop any existing 'parkings' table.
--
DROP TABLE IF EXISTS parkings;

--
-- Create 'parking' table.
--
CREATE TABLE parkings (
  id uuid PRIMARY KEY UNIQUE NOT NULL DEFAULT uuid_generate_v4(),
  license varchar(15) NOT NULL,
  state varchar(10) NOT NULL,
  model varchar(100) NOT NULL,
  color integer NOT NULL,
  bill double precision NOT NULL,
  exit_date timestamp NOT NULL,
  entry_date timestamp NOT NULL DEFAULT now(),
  updated_at timestamp NOT NULL DEFAULT now()
);
