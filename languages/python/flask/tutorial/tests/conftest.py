import os
import tempfile

import pytest
from flaskr import create_app
from flaskr.db import get_db, init_db

with open(os.path.join(os.path.dirname(__file__), 'data.sql'), 'rb') as f:
  _data_sql = f.read().decode('utf8')

@pytest.fixture
def app():
  # 一時ファイルの作成
  db_fd, db_path = tempfile.mkstemp()

  app = create_app({
    'TESTING': True,     # テストモード
    'DATABASE': db_path
  })

  with app.app_context():
    init_db()
    get_db().executescript(_data_sql)

  yield app

  os.close(db_fd)
  os.unlink(db_path)

@pytest.fixture
def client(app):
  return app.test_client()

# clickコマンドを呼び出すためのランナー
@pytest.fixture
def runner(app):
  return app.test_cli_runner()

class AuthActions(object):
  def __init__(self, client):
    self._client = client

  def login(self, username='test', password='test'):
    return self._client.post(
      '/auth/login',
      data={'username': username, 'password': password}
    )

@pytest.fixture
def auth(client):
  return AuthActions(client)
