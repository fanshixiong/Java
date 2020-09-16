import { createStore } from 'vuex'

export default createStore({
  state: {
    counter: 10,
    students: [
      { id: 110, name: 'zzz', age: '18' },
      { id: 111, name: 'ttt', age: '20' },
      { id: 112, name: 'yyy', age: '22' },
      { id: 113, name: 'zty', age: '25' }
    ]
  },
  mutations: {
    increment (state) {
      state.counter++
    },
    decrement (state) {
      state.counter--
    },
    incrementCount (state, count) {
      state.counter += count
    },
    addStu (state, stu) {
      state.students.push(stu)
    }
  },
  actions: {
  },
  getters: {
    powerCounter (state) {
      return state.counter * state.counter
    },
    getStudentCounts: state => {
      return state.students.filter(s => s.age > 20).length
    },
    stuCount () {
      return this.$store.getters.getStudents
    },
    moreAgeStu (state) {
      // return function (age) {
      //   return state.students.filter(s => s.age > age)
      // }
      return age => {
        return state.students.filter(s => s.age > age)
      }
    }
  },
  modules: {
  }
})
