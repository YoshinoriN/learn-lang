const path = require('path');
const CopyWebpackPlugin = require('copy-webpack-plugin');
const ExtractTextPlugin = require('extract-text-webpack-plugin');

module.exports = [
  {
    context: path.join(__dirname, './src/_js'),
    entry: {
      style: "./index.js",
    },
    output: {
      path: path.join(__dirname, './dist'),
      filename: 'main.js'
    },
    module: {
      rules: [
        {
          test: /\.vue$/,
          exclude: /node_modules/,
          loader: 'vue-loader'
        },
        {
          test: /\.js$/,
          loader: 'babel-loader',
          exclude: /node_modules/
        },
      ],
    },
    plugins: [
      new CopyWebpackPlugin([
        {
          from: path.resolve(__dirname, 'src/_js'),
          to: path.resolve(__dirname, 'dist')
        }
      ]),
    ],
    resolve: {
      alias: {
        'vue$': 'vue/dist/vue.js'
      },
    }
  },
  {
    context: path.join(__dirname, './src/_scss'),
    entry: {
      style: "./style.scss",
    },
    output: {
      path: path.join(__dirname, './dist'),
      filename: 'style.css'
    },
    module: {
      rules: [
        {
          test: /\.scss$/,
          use: ExtractTextPlugin.extract({
            fallback: 'style-loader',
            use: ['css-loader', 'sass-loader']
          })
        }
      ]
    },
    plugins: [
      new ExtractTextPlugin('[name].css')
    ]
  }
]
