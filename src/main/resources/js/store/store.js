import Vue from 'vue'
import Vuex from 'vuex'
import messagesApi from '../api/messages'
import commentApi from '../api/comment'
import champsApi from '../api/champs'


Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        messages,
        profile,
        champs: frontendData.champs,
        persons: frontendData.persons,
        users: frontendData.users,
        ...frontendData
    },
    getters: {
        sortedMessages: state => (state.messages || []).sort((a, b) => -(a.id - b.id)),
        sortedChamps: state => (state.champs || []).sort((a, b) => -(a.id - b.id)),
        sortedUsers: state => (state.users || []).sort((a, b) => -(a.id - b.id)),
        sortedPerson: state => (state.persons || []).sort((a, b) => -(a.id - b.id)),
    },
    mutations: {
        addMessageMutation(state, message) {
            state.messages = [
                ...state.messages,
                message
            ]
        },
        updateMessageMutation(state, message) {
            const updateIndex = state.messages.findIndex(item => item.id === message.id)

            state.messages = [
                ...state.messages.slice(0, updateIndex),
                message,
                ...state.messages.slice(updateIndex + 1)
            ]
        },
        removeMessageMutation(state, message) {
            const deletionIndex = state.messages.findIndex(item => item.id === message.id)

            if (deletionIndex > -1) {
                state.messages = [
                    ...state.messages.slice(0, deletionIndex),
                    ...state.messages.slice(deletionIndex + 1)
                ]
            }
        },
        addCommentMutation(state, comment) {
            const updateIndex = state.messages.findIndex(item => item.id === comment.message.id)
            const message = state.messages[updateIndex]

            //if (!message.comments.find(it => it.id === comment.id))
            if (!(message.comments || []).find(it => it.id === comment.id))
            {
                state.messages = [
                    ...state.messages.slice(0, updateIndex),
                    {
                        ...message,
                        comments: message.comments === null ? [comment] : [...message.comments, comment]
                    },
                    ...state.messages.slice(updateIndex + 1)
                ]
            }
        },
        addMessagePageMutation(state, messages) {
            const targetMessages = state.messages
                .concat(messages)
                .reduce((res, val) => {
                    res[val.id] = val
                    return res
                }, {})

            state.messages = Object.values(targetMessages)
        },
        updateTotalPagesMutation(state, totalPages) {
            state.totalPages = totalPages
        },
        updateCurrentPageMutation(state, currentPage) {
            state.currentPage = currentPage
        },
        addChampMutation(state, champ) {
            state.champs = [
                ...state.champs,
                champ
            ]
        },
        updateChampMutation(state, champ) {
            const updateIndex = state.champs.findIndex(item => item.id === champ.id)

            state.champs = [
                ...state.champs.slice(0, updateIndex),
                champ,
                ...state.champs.slice(updateIndex + 1)
            ]
        },
        removeChampMutation(state, champ) {
            const deletionIndex = state.champs.findIndex(item => item.id === champ.id)

            if (deletionIndex > -1) {
                state.champs = [
                    ...state.champs.slice(0, deletionIndex),
                    ...state.champs.slice(deletionIndex + 1)
                ]
            }
        }
    },
    actions: {
        async addMessageAction({commit, state}, message) {
            const result = await messagesApi.add(message)
            const data = await result.json()
            const index = state.messages.findIndex(item => item.id === data.id)

            if (index > -1) {
                commit('updateMessageMutation', data)
            } else {
                commit('addMessageMutation', data)
            }
        },
        async updateMessageAction({commit}, message) {
            const result = await messagesApi.update(message)
            const data = await result.json()
            commit('updateMessageMutation', data)
        },
        async removeMessageAction({commit}, message) {
            const result = await messagesApi.remove(message.id)

            if (result.ok) {
                commit('removeMessageMutation', message)
            }
        },
        async addCommentAction({commit, state}, comment) {
            const response = await commentApi.add(comment)
            const data = await response.json()
            commit('addCommentMutation', data)
        },
        async loadPageAction({commit, state}) {
            const response = await messagesApi.page(state.currentPage + 1)
            const data = await response.json()

            commit('addMessagePageMutation', data.messages)
            commit('updateTotalPagesMutation', data.totalPages)
            commit('updateCurrentPageMutation', Math.min(data.currentPage, data.totalPages - 1))
        },

        async addChampAction({commit, state}, champ) {
            const result = await champsApi.add(champ)
            const data = await result.json()
            const index = state.champs.findIndex(item => item.id === data.id)

            if (index > -1) {
                commit('updateChampMutation', data)
            } else {
                commit('addChampMutation', data)
            }
        },
        async updateChampAction({commit}, champ) {
            const result = await champsApi.update(champ)
            const data = await result.json()
            commit('updateChampMutation', data)
        },

        async removeChampAction({commit}, champ) {
            const result = await champsApi.remove(champ.id)

            if (result.ok) {
                commit('removeChampMutation', champ)
            }
        },
    }
})
