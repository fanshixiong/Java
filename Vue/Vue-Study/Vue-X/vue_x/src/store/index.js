import { createStore } from 'vuex'
const moduleA = {
  state: () => ({
    count: 1,
    name: 'frans-modules'
  }),
  mutations: {
    increment (state) {
      // 这里的 `state` 对象是模块的局部状态
      state.count++
    }
  },
  actions: {
    incrementIfOddOnRootSum (context) {
      if ((context.state.count + context.rootState.count) % 2 === 1) {
        context.commit('increment')
      }
    }
  },
  getters: {
    doubleCount (state, getters, rootState) {
      console.log(rootState.count) // 获取的是根状态的count
      return state.count * 2
    }
  }
}
export default createStore({
  state: {
    counter: 10,
    count: 20,
    students: [
      { id: 110, name: 'zzz', age: '18' },
      { id: 111, name: 'ttt', age: '20' },
      { id: 112, name: 'yyy', age: '22' },
      { id: 113, name: 'zty', age: '25' }
    ],
    user: { id: 110, name: 'frans', age: '18' }
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
    },
    updateName (state, name) {
      state.user.name = name
    }
  },
  actions: {
    // context：上下文
    /*
    aUpdateInfo (context, name) {
      setTimeout(() => {
        context.commit('updateName', name)
      }, 1000)
    }
    */
    aUpdateInfo (context, payload) {
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          context.commit('updateName')
          console.log(payload)
          resolve('11111111')
        }, 1000)
      })
    }
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
    a: moduleA
  }
})
