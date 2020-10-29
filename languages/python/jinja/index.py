import jinja2

fileSystemLoader = jinja2.FileSystemLoader(searchpath="./templates")
env = jinja2.Environment(loader=fileSystemLoader)
template = env.get_template('test.tpl')

file = open('./dist/test.md', 'w')
file.write(template.render())
