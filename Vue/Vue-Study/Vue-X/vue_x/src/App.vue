<template>
  <div id="app">
    <h2>{{message}}</h2>
    <h2>{{$store.state.counter}}</h2>
    <button @click="add">+</button>
    <button @click="sub">-</button>
    <button @click="addCount(6)">+6</button>
    <button @click="addCount(10)">+10</button>
    <button @click="addStu">添加学生</button>

    <h2>--------------getters--------------</h2>
    <h2>{{$store.getters.powerCounter}}</h2>
    <h2>{{$store.getters.getStudentCounts}}</h2>
    <h2>{{$store.getters.moreAgeStu(18)}}</h2>
    <hello-vuex :counter="counter"/>

    <h2>--------------action-----------------</h2>
    <button @click="change">change</button>
    <h2>{{$store.state.user}}</h2>

    <h2>----------------modules----------------</h2>
    <h2>{{$store.state.a.name}}</h2>
    <button @click="test">test</button>
    <h2>{{$store.state.a.count}}</h2>
    <h2>{{$store.state.count}}</h2>
  </div>
</template>
<script>
import HelloVuex from './components/HelloVuex'
export default {
  name: 'App',
  components: {
    HelloVuex
  },
  data () {
    return {
      message: '组件'
    }
  },
  methods: {
    add () {
      this.$store.commit('increment')
    },
    sub () {
      this.$store.commit('decrement')
    },
    addCount (count) {
      this.$store.commit('incrementCount', count)
      this.$store.commit({
        type: 'incrementCount',
        count
      })
    },
    addStu () {
      const stu = { id: 115, name: 'alan', age: 36 }
      this.$store.commit('addStu', stu)
    },
    /*
    change () {
      this.$store.dispatch('aUpdateInfo', 'ffrans')
    }
    */
    change () {
      this.$store.dispatch('aUpdateInfo', 'frans4x').then(res => {
        console.log('success')
        console.log(res)
      })
    },
    test () {
      this.$store.dispatch('incrementIfOddOnRootSum')
    }
  },
  computed: {
    stuCount () {
      return this.$store.state.students.filter(student => student.age > 20).length
    }
  }
}
</script>
<style>
</style>
