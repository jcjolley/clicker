-- :name create-user! :! :n
-- :doc creates a new user record
INSERT INTO users
(username, password, email, admin)
VALUES (:username, :password, :email, :admin)

-- :name update-user! :! :n
-- :doc update an existing user record
UPDATE users
SET name email = :email, admin = :admin
WHERE id = :id

-- :name get-user :? :1
-- :doc retrieve a user given the id.
SELECT * FROM users
WHERE id = :id

-- :name delete-user! :! :n
-- :doc delete a user given the id
DELETE FROM users
WHERE id = :id
