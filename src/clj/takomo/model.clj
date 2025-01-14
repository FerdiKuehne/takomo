(ns takomo.model
  (:require [clojure.spec.alpha :as s])
  (:import [java.lang Long]))

(defn long? [x]
  (instance? Long x))

(s/def :db/id int?)

(s/def ::id int?)

(s/def :member/firstname string?)
(s/def :member/lastname string?)
(s/def :member/email string?)
(s/def :member/salt string?)
(s/def :member/passhash string?)
(s/def :member/password string?)
(s/def ::member (s/keys :opt [:db/id :member/firstname :member/lastname :member/email :member/password]))
(s/def ::members (s/coll-of ::member))

(s/def :customer/name string?)
(s/def :customer/contact string?)
(s/def :customer/department string?)
(s/def :customer/city string?)
(s/def :customer/street string?)
(s/def :customer/postal string?)
(s/def :customer/country string?)
(s/def ::customer (s/keys :opt [:db/id
                                :customer/name
                                :customer/contact
                                :customer/department
                                :customer/city
                                :customer/street
                                :customer/postal
                                :customer/country]))
(s/def ::customers (s/coll-of ::customer))

(s/def :document/reference string?)
(s/def :document/fileName string?)
(s/def ::document (s/keys :opt [:db/id :document/fileName :document/reference]))
(s/def ::documents (s/coll-of ::document))

(s/def :task/title string?)
(s/def :task/description string?)
(s/def :task/assignees (s/coll-of ::id))
(s/def :task/estimation double?)
(s/def :task.estimation/unit keyword?)
(s/def :task/reference string?)
(s/def :task/project ::id)

(s/def ::task (s/keys :opt [:db/id :task/title :task/description :task/assignees :task/estimation :task.estimation/unit :task/project :task/reference]))
(s/def ::tasks (s/coll-of ::task))

(s/def :effort/startDate string?)
(s/def :effort/endDate string?)
(s/def :effort/description string?)
(s/def :effort/reference string?)
(s/def :effort/task ::id)
(s/def :effort/assignee ::id)
(s/def ::effort (s/keys :opt [:db/id :effort/startDate :effort/endDate :effort/description :effort/task :effort/assignee :effort/reference]))
(s/def ::efforts (s/coll-of ::effort))

(s/def :project/title string?)
(s/def :project/description string?)
(s/def :project/startDate string?)
(s/def :project/endDate string?)
(s/def :project/acceptedAt string?)
(s/def :project/paidAt string?)
(s/def :project/customer ::id)
(s/def :project/members (s/coll-of ::id))
(s/def :project/invoice ::id)
(s/def :project/offers (s/coll-of ::id))
(s/def :project/responsible int?)
(s/def :project/rate int?)
(s/def :project.rate/unit keyword?)
(s/def :project/reference string?)
(s/def ::project (s/keys :opt [:db/id
                               :project/reference
                               :project/title
                               :project/description
                               :project/responsible
                               :project/startDate
                               :project/endDate
                               :project/acceptedAt
                               :project/paidAt
                               :project/customer
                               :project/members
                               :project/invoice
                               :project/offers
                               :project/rate
                               :project.rate/unit]))
(s/def ::projects (s/coll-of ::project))
