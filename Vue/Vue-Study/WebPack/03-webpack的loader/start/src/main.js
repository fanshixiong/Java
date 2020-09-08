const {add, mul} = require('./js/mathUtils.js')

console.log(add(20, 30));
console.log(mul(20, 30));

import {name, age, height} from './js/info'

console.log(name);
console.log(age);
console.log(height);

require('./css/normal.css')
require('./css/special.less')
document.writeln('<h2>frans</h2>')


//vue
import Vue from 'vue'
// import App from './vue/App'
import App from './vue/App.vue'
/*const app = */
new Vue({
    el: '#app',
    template: '<App/>',
    components:{
        App,
    }
});
document.writeln('<h1>woshi </h1>')

