## Jinja2

{% for n in range(1, 3) %}
* {{ n }} 番目
  {%- for m in range(1, 4) %}
    * {{ m }} 番目
  {%- endfor -%}
{% endfor %}

OWARI
