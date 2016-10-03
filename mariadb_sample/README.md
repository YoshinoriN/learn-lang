```sh
sudo apt-get upgrade
sudo apt-get update
sudo apt-get install ruby-dev
sudo apt-get install libmysql-dev

gem install libv8
sudo apt-get install build-essential g++
```

# Database Migration

```sh
rake db:create:all
rake db:migrate
```

# Using Unicorn

```sh
bundle exec unicorn_rails -c config/unicorn.rb -E development

To access http://example.com:3000
```
