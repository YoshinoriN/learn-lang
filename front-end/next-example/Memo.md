
# バックグラウンド

現時点の自分のバックグラウンドを書き残しておく。

* メインはバックエンド
* Vue 1.x~2.xはそれなりに使っている
    * 3はよく知らない
* Nuxtは 2.x をいくつか触っている
* SCSS, CSS, webpack etc...はなんとなく触ることができる

どちらも画面数が少ないものならSSGで一から実装はできる。実務でも一から実装したことはある。

デザインでいうとAtomicデザインはいちおう簡単には習得している。

# 環境

* Next.js 10.5.0


# 機能

* ホットリロード

## ルーティング

* `pages`配下はルーティングされる
    * SSGとSSRの場合
    * `pages/about.js` とかすると `http://localhost:3000/about`でアクセスできる
* `public`配下は`/`にマッピングされる
    * `public/test.txt`とかすると `http://localhost:3000/test.txt`でアクセスできる
* 動的ルーティング
    * `pages/post/[id].js`

## プレ・レンダリング

> By default, Next.js pre-renders every page. This means that Next.js generates HTML for each page in advance, instead of having it all done by client-side JavaScript. Pre-rendering can result in better performance and SEO.

> Next.js has two forms of pre-rendering: Static Generation and Server-side Rendering. The difference is in when it generates the HTML for a page.

SSRとSSGのことをまとめてプレ・レンダリングといっているようだ。SSRはプレ・レンダリングといっていいのか？？

NextではページごとにSSGとSSRのどちらを使用するか設定できる。

### SSG

ビルド時にHTML吐き出すやつ。これはやり慣れてるので理解している。このサイトも開設時からずっとSSG。

#### 静的生成と外部データ

SSGするためにあらかじめ外部データを取得しておく必要がある場合、下記を使用する。

* コンテンツを取得する: getStaticProps
    * ページからのみexportできる
* URLを取得する: getStaticPaths
    * `pages/post/[id].js`みたいな動的ルーティングで事前に`id`ごとのページ生成しておくのに使う
    * ページからのみexportできる

どちらも`export async`する。

#### 増分SSG (Incremental Static Regeneration)

定期的にコンテンツの変更を監視して、変更があればHTMLを生成しなおすというのができるらしい。

### SSR

リクエストごとにHTMLを生成する。SSRするには `getServerSideProps`関数を使う。どちらも`export async`する。

クライアント側でデータを取得するものではない。（サーバサイドと何が違うんだ）

## ハイドレーション (hydration)

> Each generated HTML is associated with minimal JavaScript code necessary for that page. When a page is loaded by the browser, its JavaScript code runs and makes the page fully interactive. (This process is called hydration.)

ページに必要なJavaScript紐づけて表示するやつらしい。ちゃんと名前がついていた。

## SWR

データ取得するためのReact hook。React hookがよくわかってないので今回は省略。

## CSS

* `pages/_app.js`で`import`する
* `node_modules`のもも`import`できる
* `[name].module.css`でコンポーネント別にCSS作成できる
    * Vueの`scoped`つけた`style`みたいなやつ？？
* Sass/Scss
    * 別途`npm install`する
    * `[name].module.scss`, `[name].module.sass`でコンポーネント別に適用できる
    * `next.config.js`でオプション変更できる
* インラインスタイルも書ける
    * [styled-jsx](https://github.com/vercel/styled-jsx)でスタイルを分離できる

## よくわかっていないやつ

* JSX
    * DOMごにょごにょしてくれるやつくらいの認識
* Nuxtの時も思ったが、わざわざNextを使う理由がよくわかってない
    * 以前プロジェクトでやったときに`vue create`で十分じゃないかと思った
        * SSRしないならいらないのでは？？
    * フロントエンドのフルスタックフレームワークと思えばよいのか？
    * 必要なライブラリを自分で選定してくる場合はいらない？？？
* SSR
    * 必要性がよくわからない
    * 要するにBFFというやつ？？
* props
    * Vueと同じ概念？
* Headless CMS
    * WordPressのAPIみたいな認識
    * ただのAPIサーバと思ってたけど、わざわざ言葉を使い分けてる（？）ということはAPIサーバ違う？？
* React hook
    * なんか新しいやつというぐらいしかしらない

## その他

だいたいサンプルのコードが存在するので便利

>  https://github.com/vercel/next.js/tree/canary/examples

Reactの説明はないので結局Reactのチュートリアルからやらないといけない気がする。
