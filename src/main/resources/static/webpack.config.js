const webpack = require('webpack');
const path = require('path');

//自动生成dist里的index.html文件的插件
const HtmlWebpackPlugin = require('html-webpack-plugin');
//自动清除dist下的文件
const CleanWebpackPlugin = require('clean-webpack-plugin');
//webpack处理的文件清单
var ManifestPlugin = require('webpack-manifest-plugin');

module.exports = {
    entry: {
        index: './src/index.js'
    },
    output: {
        path: path.resolve(__dirname, 'build'),
        filename: '[name].js'
    },
    module: {
        rules: [
            {
                test: /\.(js|jsx)$/,
                use: 'babel-loader',
                exclude: /node_modules/
            },
            {
                test: /\.css$/,
                use: ['style-loader', 'css-loader?importLoaders=1']
            }
        ]
    },
    plugins: [
        new CleanWebpackPlugin(['dist']),
        new HtmlWebpackPlugin({
          title: 'UI Component Lib',
          template: 'public/index.html' // 源模板文件
        }),
        new ManifestPlugin(),
        // new webpack.optimize.UglifyJsPlugin(),
        new webpack.HotModuleReplacementPlugin(), //热更新
        new webpack.NamedModulesPlugin() //在控制台打印模块
    ],
    devtool: 'eval'
}