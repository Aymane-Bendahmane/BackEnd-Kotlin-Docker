-- Migration script to add stock column to the product table
ALTER TABLE product
    ADD COLUMN IF NOT EXISTS stock INT;
