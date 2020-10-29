import jinja2

fileSystemLoader = jinja2.FileSystemLoader(searchpath="./templates")
env = jinja2.Environment(loader=fileSystemLoader)
template = env.get_template('test2.tpl')

file = open('./dist/test2.md', 'w')
file.write(template.render({
	'title': 'Hello Jinja2'
	,'x': 4
	,'y': 3
	,'bunmatsu': 'Bye'
}))
