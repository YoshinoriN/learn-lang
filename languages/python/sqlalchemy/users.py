from sqlalchemy.schema import Column
from sqlalchemy.types import Integer, String
from sqlalchemy.ext.declarative import declarative_base

Base = declarative_base()

class Users(Base):
	__tablename__ = 'users'

	id = Column(String, primary_key=True)
	name = Column(String)
	mailaddress = Column(String)
	createdAt = Column(Integer, name = 'created_at')

	def print(self):
		for k, v in self.__dict__.items():
  			print(k, ':', v)

