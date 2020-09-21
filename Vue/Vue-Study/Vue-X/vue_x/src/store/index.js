import { createStore } from 'vuex'

import mutations from './mutations'
import actions from './actions'
import getters from './getters'
import moduleA from './modules/moduleA'

const state = {
  counter: 10,
  count: 20,
  students: [
    { id: 110, name: 'zzz', age: '18' },
    { id: 111, name: 'ttt', age: '20' },
    { id: 112, name: 'yyy', age: '22' },
    { id: 113, name: 'zty', age: '25' }
  ],
  user: { id: 110, name: 'frans', age: '18' }
}

export default createStore({
  state,
  mutations,
  actions,
  getters,
  modules: {
    a: moduleA
  }
})
