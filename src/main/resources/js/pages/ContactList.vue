<template>
  <v-container>
    <v-layout align-space-around justify-start column>
      <contact-form :contactAttr="contact" />
      <contact-row v-for="contact in sortedContacts"
                   :key="contact.id"
                   :contact="contact"
                   :editContact="editContact" />
    </v-layout>
  </v-container>
</template>

<script>
import { mapGetters } from 'vuex'
import ContactRow from 'components/contacts/ContactRow.vue'
import ContactForm from 'components/contacts/ContactForm.vue'

export default {
  components: {
    ContactRow,
    ContactForm
  },
  data() {
    return {
      contact: null
    }
  },
  computed: mapGetters(['sortedContacts']),
  methods: {
    editContact(contact) {
      this.contact = contact
    }
  }
}
</script>

<style>

</style>
