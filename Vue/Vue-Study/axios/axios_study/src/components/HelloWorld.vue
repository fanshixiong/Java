<template>
  <div>{{categories}}</div>
  <button @click="btnclick">点我</button>
</template>

<script>
import axios from 'axios'
import { request } from '../network/request'
export default {
  name: 'HelloWorld',
  data () {
    return {
      categories: ''
    }
  },
  props: {
  },
  created () {
    axios({
      url: 'http://123.207.32.32:8000/category'
    }).then(res => {
      this.categories = res
    })
  },
  methods: {
    btnClick () {
      request({
        url: '/home/multidata'
      }).then(res => {
        console.log(res)
      }).catch(err => {
        console.log(err)
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
