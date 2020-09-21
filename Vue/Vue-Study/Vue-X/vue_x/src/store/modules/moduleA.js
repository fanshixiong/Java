export default {
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
