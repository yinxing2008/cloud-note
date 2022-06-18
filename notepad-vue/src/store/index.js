/**
 * 厦门大学计算机专业 | 前华为工程师
 * 专注《零基础学编程系列》  http://lblbc.cn/blog
 * 包含：Java | 安卓 | 前端 | Flutter | iOS | 小程序 | 鸿蒙
 * 公众号：蓝不蓝编程
 */
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({

    state: {
        userToken: '',
    },

    mutations: {
        setUserToken(userToken) {
            this.state.userToken = userToken
        },
    },

    getters: {
        getUserToken: state => state.userToken,
    },

    actions: {
    },

    modules: {
    }
})

