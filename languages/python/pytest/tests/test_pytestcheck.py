import pytest_check as check

class TestExample(object):

	def test_a(self):
		check.equal(1, 1)
		check.equal(1, 2)
		check.equal(3, 3)
		check.equal(4, 4)
		check.equal(5, 6)
		check.equal(7, 7)
