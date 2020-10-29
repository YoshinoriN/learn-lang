## {{ title }}

{% for n in range(1, x) %}
* {{ n }} 番目
  {%- for m in range(1, y) %}
    * {{ m }} 番目
  {%- endfor -%}
{% endfor %}

{{ bunmatsu }}
