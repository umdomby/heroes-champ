<template>

<!--  <v-container class="pa-1">-->
<!--    <v-row>-->

<!--      <v-col order="last">-->
<!--        <v-card-->
<!--            class="pa-1"-->
<!--            outlined-->
<!--            tile-->
<!--        >-->
<!--          <user-link-->
<!--              :user="contact.author"-->
<!--              size="18"-->
<!--          ></user-link>-->
<!--          <span>-->
<!--            <input type="button" value="Edit" @click="edit" />-->
<!--            <input type="button" value="X" @click="del" />-->
<!--          </span>-->
<!--        </v-card>-->
<!--      </v-col>-->

<!--      <v-col order="first">-->
<!--        <v-card-->
<!--            class="pa-1"-->
<!--            outlined-->
<!--            tile-->
<!--        >-->
<!--          <i>({{ contact.id }})</i> {{ contact.text }}-->
<!--        </v-card>-->
<!--      </v-col>-->

<!--    </v-row>-->
<!--  </v-container>-->




    <div>
      <v-container py-0 px-2>
        <user-link
            :user="contact.author"
            size="18"

        ></user-link>
        <span style="position: absolute; right: 0">
            <input type="button" value="Edit" @click="edit" />
            <input type="button" value="X" @click="del" />
        </span>
        <i>({{ contact.id }})</i> {{ contact.text }}

      </v-container>
    </div>

</template>

<script>

import UserLink from 'components/UserLink.vue'

    export default {
        props: ['contact', 'editContact', 'deleteContact', 'contacts'],
        components: {UserLink},
        methods: {
            edit() {
                this.editContact(this.contact)
            },
            del() {
                this.deleteContact(this.contact)
            }
        }
    }
</script>

<style>

</style>
