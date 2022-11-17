--
-- Add extension to use 'uuid_generate_v4'.
--
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

--
-- Create 'parking' table.
--
CREATE TABLE parkings (
  id uuid PRIMARY KEY UNIQUE NOT NULL DEFAULT uuid_generate_v4(),
  license char(15) NOT NULL,
  state char(100) NOT NULL,
  model char(100) NOT NULL,
  color integer NOT NULL,
  bill double precision NOT NULL,
  created_at timestamp NOT NULL DEFAULT now(),
  updated_at timestamp NOT NULL DEFAULT now()
);