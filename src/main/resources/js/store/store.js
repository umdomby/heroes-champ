import Vue from 'vue'
import Vuex from 'vuex'
import messagesApi from '../api/messages'
import commentApi from '../api/comment'
import contactsApi from '../api/contacts'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        messages,
        profile,
        contacts: frontendData.contacts,
        ...frontendData
    },
    getters: {
        sortedMessages: state => (state.messages || []).sort((a, b) => -(a.id - b.id)),
        sortedContacts: state => (state.contacts || []).sort((a, b) => -(a.id - b.id)),
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
        addContactMutation(state, contact) {
            state.contacts = [
                ...state.contacts,
                contact
            ]
        },
        updateContactMutation(state, contact) {
            const updateIndex = state.contacts.findIndex(item => item.id === contact.id)

            state.contacts = [
                ...state.contacts.slice(0, updateIndex),
                contact,
                ...state.contacts.slice(updateIndex + 1)
            ]
        },
        removeContactMutation(state, contact) {
            const deletionIndex = state.contacts.findIndex(item => item.id === contact.id)

            if (deletionIndex > -1) {
                state.contacts = [
                    ...state.contacts.slice(0, deletionIndex),
                    ...state.contacts.slice(deletionIndex + 1)
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

        async addContactAction({commit, state}, contact) {
            const result = await contactsApi.add(contact)
            const data = await result.json()
            const index = state.contacts.findIndex(item => item.id === data.id)

            if (index > -1) {
                commit('updateContactMutation', data)
            } else {
                commit('addContactMutation', data)
            }
        },
        async updateContactAction({commit}, contact) {
            const result = await contactsApi.update(contact)
            const data = await result.json()
            commit('updateContactMutation', data)
        },
        async removeContactAction({commit}, contact) {
            const result = await contactsApi.remove(contact.id)

            if (result.ok) {
                commit('removeContactMutation', contact)
            }
        },
    }
})
