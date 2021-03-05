<template>
  <v-container>
    <v-layout v-if="profile" align-space-around justify-start column>
      <contacts-list :contacts="contacts" />
    </v-layout>
  </v-container>
</template>

<script>

import ContactsList from '../components/contacts/ContactList.vue'
import { mapState } from 'vuex'

export default {
  name: "Contact2",
  computed: mapState(['profile']),
  components: {
    ContactsList
  },
  data() {
    return {
      contacts: frontendData.contacts,
    }
  }
}
</script>

<style scoped>

</style>