<template>
    <v-app>
        <v-toolbar app>
          <v-btn flat
                 :disabled="$route.path === '/main'"
                 @click="showMain">
            Main
          </v-btn>
          <v-btn flat
                 v-if="profile"
                 :disabled="$route.path === '/'"
                 @click="showMessages">
            Messages
          </v-btn>
          <v-btn flat
                 :disabled="$route.path === '/contact'"
                 @click="showContact">
            Contact
          </v-btn>
            <v-spacer></v-spacer>
            <v-btn flat
                   v-if="profile"
                   :disabled="$route.path === '/user'"
                   @click="showProfile">
                {{profile.name}}
            </v-btn>
            <v-btn v-if="profile" icon href="/logout">
                <v-icon>exit_to_app</v-icon>
            </v-btn>
            <div v-else>
              <a href="/login"> вход google</a>
            </div>

        </v-toolbar>
        <v-content>
          <router-view></router-view>
        </v-content>
    </v-app>
</template>

<script>
    import { mapState, mapMutations } from 'vuex'
    import { addHandler } from 'util/ws'

    export default {
        computed: mapState(['profile']),
        methods: {
            ...mapMutations([
                'addMessageMutation',
                'updateMessageMutation',
                'removeMessageMutation',
                'addCommentMutation'
            ]),
            showMain() {
              this.$router.push('/main')
            },
            showMessages() {
                this.$router.push('/')
            },
            showContact() {
              this.$router.push('/contact')
            },
            showProfile() {
                this.$router.push('/user')
            }
        },
        created() {
            addHandler(data => {
                if (data.objectType === 'MESSAGE') {
                    switch (data.eventType) {
                        case 'CREATE':
                            this.addMessageMutation(data.body)
                            break
                        case 'UPDATE':
                            this.updateMessageMutation(data.body)
                            break
                        case 'REMOVE':
                            this.removeMessageMutation(data.body)
                            break
                        default:
                            console.error(`Looks like the event type if unknown "${data.eventType}"`)
                    }
                } else if (data.objectType === 'COMMENT') {
                    switch (data.eventType) {
                        case 'CREATE':
                            this.addCommentMutation(data.body)
                            break
                        default:
                            console.error(`Looks like the event type if unknown "${data.eventType}"`)
                    }
                } else {
                    console.error(`Looks like the object type if unknown "${data.objectType}"`)
                }
            })
        },
        beforeMount() {
            if (!this.profile) {
                this.$router.replace('/main')
            }
            else if (this.profile) {
              this.$router.replace('/main')
            }
        }
    }
</script>

<style>

</style>
