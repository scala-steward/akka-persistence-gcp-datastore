/*
 * Copyright 2020 innFactory GmbH | innfactory.de
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package akka.persistence.datastore.journal
import akka.actor.ActorSystem
import akka.persistence.CapabilityFlag
import akka.persistence.journal.JournalSpec
import com.typesafe.config.ConfigFactory

class DatastoreJournalSpec
    extends JournalSpec(
      config = ConfigFactory.parseString("""akka.persistence.journal.plugin = "gcp-datastore-journal"""")
    ) {

  val actorSystem: ActorSystem = ActorSystem("test", config)

  override def supportsRejectingNonSerializableObjects: CapabilityFlag =
    false // or CapabilityFlag.off

  override def supportsSerialization: CapabilityFlag =
    true // or CapabilityFlag.on
}
