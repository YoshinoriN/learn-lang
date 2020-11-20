from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from users import Users
import uuid
import time

config = {
	"host": "127.0.0.1",
	"port": 3306,
	"user": "root",
	"pass": "pass",
	"schema": "exampleschema",
}

connectionString = 'mysql+pymysql://{0[user]}:{0[pass]}@{0[host]}:{0[port]}/{0[schema]}?charset=utf8mb4'.format(config)
engine = create_engine(connectionString)

SessionClass = sessionmaker(engine)
session = SessionClass()

# INSERT
users = list()
for i in range(0, 5):
	user = Users()
	user.id = str(uuid.uuid4())
	user.name = "user_{0}".format(i)
	user.mailaddress = "user{0}@example.com".format(i)
	user.createdAt = int(time.time())

	users.append(user)

try:
	session.add_all(users)
	session.commit()
except Exception as e:
	print(e)
finally:
	session.close()

# SELECT
users.clear()
try:
	users.extend(session.query(Users).filter_by(
		name = 'user_1'
	).all())

	users.extend(session.query(Users).filter_by(
		name = 'user_3'
	).all())

	for user in users:
		user.print()
except Exception as e:
	print(e)
finally:
	session.close()

# DELETE
users.clear()
try:
	users.extend(session.query(Users).all())
	for user in users:
		session.delete(user)
		session.commit()
except Exception as e:
	print(e)
finally:
	session.close()
